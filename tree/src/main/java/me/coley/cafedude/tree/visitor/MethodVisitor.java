package me.coley.cafedude.tree.visitor;

import me.coley.cafedude.classfile.annotation.ElementValue;
import me.coley.cafedude.tree.Constant;
import org.jetbrains.annotations.Nullable;

/**
 * Visitor for visiting method information.
 */
public interface MethodVisitor extends DeclarationVisitor {

	/**
	 * Return the delegate visitor for pass through implementations.
	 * @return Delegate visitor.
	 */
	@Nullable
	default MethodVisitor methodDelegate() {
		return null;
	}

	@Override
	default DeclarationVisitor declarationDelegate() {
		return methodDelegate();
	}

	/**
	 * Visit the code of the method.
	 * @return A visitor for the code.
	 */
	default CodeVisitor visitCode() {
		MethodVisitor delegate = methodDelegate();
		if(delegate != null) return delegate.visitCode();
		return null;
	}

	/**
	 * Visit a thrown exception.
	 *
	 * @param type
	 * 		  Type of the exception.
	 */
	default void visitThrows(String type) {
		MethodVisitor delegate = methodDelegate();
		if(delegate != null) delegate.visitThrows(type);
	}

	/**
	 * Visit a parameter annotation.
	 *
	 * @param parameter
	 * 		  Index of the parameter in the method descriptor.
	 * @param type
	 * 		  Class type of the annotation.
	 * @param visible
	 * 		  Whether the annotation is visible at runtime.
	 * @return A visitor for the annotation.
	 */
	@Nullable
	default AnnotationVisitor visitParameterAnnotation(int parameter, String type, boolean visible) {
		MethodVisitor delegate = methodDelegate();
		if(delegate != null) return delegate.visitParameterAnnotation(parameter, type, visible);
		return null;
	}

	/**
	 * Visit a method parameter
	 *
	 * @param name
	 * 		  Name of the parameter.
	 * @param access
	 * 		  Access flags.
	 */
	default void visitParameter(String name, int access) {
		MethodVisitor delegate = methodDelegate();
		if(delegate != null) delegate.visitParameter(name, access);
	}

	/**
	 * Visit the annotation default value for this method
	 * @param value
	 * 		  Default value.
	 */
	default void visitAnnotationDefault(Constant value) {
		MethodVisitor delegate = methodDelegate();
		if(delegate != null) delegate.visitAnnotationDefault(value);
	}

	/**
	 * Visit the end of the method.
	 */
	default void visitMethodEnd() {
		MethodVisitor delegate = methodDelegate();
		if(delegate != null) delegate.visitMethodEnd();
	}

}
