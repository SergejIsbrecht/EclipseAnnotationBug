package de.eso.gen;

import java.lang.String;
import org.immutables.value.Value;

@Value.Immutable
public interface MargheritaPizzaFactory {
  ImmutableMargheritaPizzaFactory factory();

  String create();
}
