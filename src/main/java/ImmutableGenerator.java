import annotation.Factory;
import annotation.ImmutableX;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
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
public class ImmutableGenerator extends AbstractProcessor {
  private ProcessingEnvironment env;

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    Set<? extends Element> elementsAnnotatedWithFactory =
        roundEnv.getElementsAnnotatedWith(Factory.class);

    elementsAnnotatedWithFactory.forEach(t -> System.out.println(t.getSimpleName().toString()));

    if (!roundEnv.processingOver()) {
      elementsAnnotatedWithFactory.forEach(
          e -> {
            String name = e.getSimpleName().toString();

            System.out.println("processe : " + name);

            String leName = name + "Factory";
            System.out.println("leName : " + leName);

            ClassName className = ClassName.get("de.eso.gen", "Immutable" + leName);
            MethodSpec factoryMethod =
                MethodSpec.methodBuilder("factory") //
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .returns(className)
                    .build();

            System.out.println(className.toString());
            System.out.println(factoryMethod.toString());

            MethodSpec createMethod =
                MethodSpec.methodBuilder("create")
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .returns(String.class)
                    .build();
            System.out.println(createMethod.toString());

            TypeSpec type =
                TypeSpec.interfaceBuilder(ClassName.get("de.eso.gen", leName))
                    .addModifiers(Modifier.PUBLIC)
                    .addMethod(factoryMethod)
                    .addMethod(createMethod)
                    .addAnnotation(ImmutableX.class)
                    .build();

            JavaFile build = JavaFile.builder("de.eso.gen", type).build();

            System.out.println(build.toString());

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
    annotataions.add(Factory.class.getCanonicalName());
    return annotataions;
  }

  @Override
  public synchronized void init(ProcessingEnvironment env) {
    this.env = env;
  }
}
