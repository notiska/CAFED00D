package me.coley.cafedude;

import me.coley.cafedude.attribute.Attribute;

import java.util.List;

/**
 * Method class member.
 *
 * @author Matt Coley
 */
public class Method extends ClassMember{
	/**
	 * @param attributes
	 * 		Attributes of the method.
	 * @param access
	 * 		Method access flags.
	 * @param nameIndex
	 * 		Index of name UTF in pool.
	 * @param typeIndex
	 * 		Index of descriptor UTF in pool.
	 */
	public Method(List<Attribute> attributes, int access, int nameIndex, int typeIndex) {
		super(attributes, access, nameIndex, typeIndex);
	}
}
