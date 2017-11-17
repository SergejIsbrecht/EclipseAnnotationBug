

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Wurst}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableWurst.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Wurst"})
public final class ImmutableWurst implements Wurst {
  private final String wurst;

  private ImmutableWurst(String wurst) {
    this.wurst = wurst;
  }

  /**
   * @return The value of the {@code wurst} attribute
   */
  @Override
  public String wurst() {
    return wurst;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Wurst#wurst() wurst} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for wurst
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWurst withWurst(String value) {
    if (this.wurst.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "wurst");
    return new ImmutableWurst(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableWurst} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableWurst
        && equalTo((ImmutableWurst) another);
  }

  private boolean equalTo(ImmutableWurst another) {
    return wurst.equals(another.wurst);
  }

  /**
   * Computes a hash code from attributes: {@code wurst}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + wurst.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Wurst} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Wurst{"
        + "wurst=" + wurst
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Wurst} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Wurst instance
   */
  public static ImmutableWurst copyOf(Wurst instance) {
    if (instance instanceof ImmutableWurst) {
      return (ImmutableWurst) instance;
    }
    return ImmutableWurst.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableWurst ImmutableWurst}.
   * @return A new ImmutableWurst builder
   */
  public static ImmutableWurst.Builder builder() {
    return new ImmutableWurst.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableWurst ImmutableWurst}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_WURST = 0x1L;
    private long initBits = 0x1L;

    private String wurst;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Wurst} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Wurst instance) {
      Objects.requireNonNull(instance, "instance");
      wurst(instance.wurst());
      return this;
    }

    /**
     * Initializes the value for the {@link Wurst#wurst() wurst} attribute.
     * @param wurst The value for wurst 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder wurst(String wurst) {
      this.wurst = Objects.requireNonNull(wurst, "wurst");
      initBits &= ~INIT_BIT_WURST;
      return this;
    }

    /**
     * Builds a new {@link ImmutableWurst ImmutableWurst}.
     * @return An immutable instance of Wurst
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableWurst build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableWurst(wurst);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_WURST) != 0) attributes.add("wurst");
      return "Cannot build Wurst, some of required attributes are not set " + attributes;
    }
  }
}
