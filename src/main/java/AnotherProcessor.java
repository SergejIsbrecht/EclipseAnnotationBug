import annotation.ImmutableX;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class AnotherProcessor extends AbstractProcessor {
  private ProcessingEnvironment env;

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    Set<? extends Element> elementsAnnotatedWithFactory =
        roundEnv.getElementsAnnotatedWith(ImmutableX.class);

    elementsAnnotatedWithFactory.forEach(e -> System.out.println(e.getSimpleName().toString()));

    if (!roundEnv.processingOver()) {
      elementsAnnotatedWithFactory.forEach(
          e -> {
            String immutableName = "Immutable" + e.getSimpleName().toString();

            TypeSpec create =
                TypeSpec.interfaceBuilder(immutableName).addModifiers(Modifier.PUBLIC).build();
            JavaFile build = JavaFile.builder("de.eso.gen", create).build();

            try {
              build.writeTo(env.getFiler());
            } catch (IOException e1) {
              throw new RuntimeException(e1);
            }
          });
    }

    return false;
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    Set<String> annotataions = new LinkedHashSet<>();
    annotataions.add(ImmutableX.class.getCanonicalName());
    return annotataions;
  }

  @Override
  public synchronized void init(ProcessingEnvironment env) {
    this.env = env;
  }
}
