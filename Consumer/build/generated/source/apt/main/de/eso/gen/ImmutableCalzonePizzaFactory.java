package de.eso.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link CalzonePizzaFactory}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCalzonePizzaFactory.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "CalzonePizzaFactory"})
public final class ImmutableCalzonePizzaFactory implements CalzonePizzaFactory {
  private final ImmutableCalzonePizzaFactory factory;
  private final String create;

  private ImmutableCalzonePizzaFactory(ImmutableCalzonePizzaFactory factory, String create) {
    this.factory = factory;
    this.create = create;
  }

  /**
   * @return The value of the {@code factory} attribute
   */
  @Override
  public ImmutableCalzonePizzaFactory factory() {
    return factory;
  }

  /**
   * @return The value of the {@code create} attribute
   */
  @Override
  public String create() {
    return create;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CalzonePizzaFactory#factory() factory} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for factory
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCalzonePizzaFactory withFactory(ImmutableCalzonePizzaFactory value) {
    if (this.factory == value) return this;
    ImmutableCalzonePizzaFactory newValue = Objects.requireNonNull(value, "factory");
    return new ImmutableCalzonePizzaFactory(newValue, this.create);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CalzonePizzaFactory#create() create} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for create
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCalzonePizzaFactory withCreate(String value) {
    if (this.create.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "create");
    return new ImmutableCalzonePizzaFactory(this.factory, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCalzonePizzaFactory} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCalzonePizzaFactory
        && equalTo((ImmutableCalzonePizzaFactory) another);
  }

  private boolean equalTo(ImmutableCalzonePizzaFactory another) {
    return factory.equals(another.factory)
        && create.equals(another.create);
  }

  /**
   * Computes a hash code from attributes: {@code factory}, {@code create}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + factory.hashCode();
    h += (h << 5) + create.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code CalzonePizzaFactory} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "CalzonePizzaFactory{"
        + "factory=" + factory
        + ", create=" + create
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link CalzonePizzaFactory} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CalzonePizzaFactory instance
   */
  public static ImmutableCalzonePizzaFactory copyOf(CalzonePizzaFactory instance) {
    if (instance instanceof ImmutableCalzonePizzaFactory) {
      return (ImmutableCalzonePizzaFactory) instance;
    }
    return ImmutableCalzonePizzaFactory.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCalzonePizzaFactory ImmutableCalzonePizzaFactory}.
   * @return A new ImmutableCalzonePizzaFactory builder
   */
  public static ImmutableCalzonePizzaFactory.Builder builder() {
    return new ImmutableCalzonePizzaFactory.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCalzonePizzaFactory ImmutableCalzonePizzaFactory}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_FACTORY = 0x1L;
    private static final long INIT_BIT_CREATE = 0x2L;
    private long initBits = 0x3L;

    private ImmutableCalzonePizzaFactory factory;
    private String create;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CalzonePizzaFactory} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CalzonePizzaFactory instance) {
      Objects.requireNonNull(instance, "instance");
      factory(instance.factory());
      create(instance.create());
      return this;
    }

    /**
     * Initializes the value for the {@link CalzonePizzaFactory#factory() factory} attribute.
     * @param factory The value for factory 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder factory(ImmutableCalzonePizzaFactory factory) {
      this.factory = Objects.requireNonNull(factory, "factory");
      initBits &= ~INIT_BIT_FACTORY;
      return this;
    }

    /**
     * Initializes the value for the {@link CalzonePizzaFactory#create() create} attribute.
     * @param create The value for create 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder create(String create) {
      this.create = Objects.requireNonNull(create, "create");
      initBits &= ~INIT_BIT_CREATE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableCalzonePizzaFactory ImmutableCalzonePizzaFactory}.
     * @return An immutable instance of CalzonePizzaFactory
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCalzonePizzaFactory build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCalzonePizzaFactory(factory, create);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_FACTORY) != 0) attributes.add("factory");
      if ((initBits & INIT_BIT_CREATE) != 0) attributes.add("create");
      return "Cannot build CalzonePizzaFactory, some of required attributes are not set " + attributes;
    }
  }
}