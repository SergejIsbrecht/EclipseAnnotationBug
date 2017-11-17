import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.immutables.value.Value;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ImmutableGenerator extends AbstractProcessor {
	private ProcessingEnvironment env;

	private List<? extends Element> elementsToProcess = new ArrayList<>();

	private int processingInt = 0;

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elementsAnnotatedWithFactory = roundEnv.getElementsAnnotatedWith(Factory.class);

		annotations.forEach(t -> System.out.println(t.toString()));
		
		if(elementsToProcess.size() == 0) {
			elementsToProcess = elementsAnnotatedWithFactory.stream().collect(Collectors.toList());	
		}
		
		if(!roundEnv.processingOver()) {
			if (processingInt < elementsToProcess.size()) {
				Element element = elementsToProcess.get(processingInt);
				
				String name = element.getSimpleName().toString();

				String leName = name + "Factory";
				TypeSpec create = TypeSpec.interfaceBuilder(leName).addModifiers(Modifier.PUBLIC)
						.addAnnotation(Value.Immutable.class)
						.addMethod(
									MethodSpec.methodBuilder("factory")//
										.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
										.returns(ClassName.get("de.eso.gen", "Immutable" + leName))
										.build()
						)
						.addMethod(
								MethodSpec.methodBuilder("create")
								.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
								.returns(String.class)
								.build()
						)
						.build();
				JavaFile build = JavaFile.builder("de.eso.gen", create).build();

				try {
					build.writeTo(env.getFiler());
				} catch (IOException e1) {
					throw new RuntimeException(e1);
				}

				processingInt++;

				return false;
			} else {
				return true;
			}
		}

		return true;
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> annotataions = new LinkedHashSet<String>();
		annotataions.add(Factory.class.getCanonicalName());
		return annotataions;
	}

	@Override
	public synchronized void init(ProcessingEnvironment env) {
		this.env = env;
	}
}
