package me.coley.cafedude.classfile.constant;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Method type pool entry. Points to an UTF constant.
 *
 * @author Matt Coley
 */
public class CpMethodType extends CpEntry {
	private CpUtf8 descriptor;

	/**
	 * @param descriptor
	 * 		Constant pool entry holding the method's descriptor.
	 */
	public CpMethodType(@Nonnull CpUtf8 descriptor) {
		super(METHOD_TYPE);
		this.descriptor = descriptor;
	}

	/**
	 * @return Constant pool entry holding the method's descriptor.
	 */
	@Nonnull
	public CpUtf8 getDescriptor() {
		return descriptor;
	}

	/**
	 * @param descriptor
	 * 		New constant pool entry holding the method's descriptor.
	 */
	public void setDescriptor(@Nonnull CpUtf8 descriptor) {
		this.descriptor = descriptor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CpMethodType that = (CpMethodType) o;
		return Objects.equals(descriptor, that.descriptor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(descriptor);
	}
}
