package com.markdown.interfaces;

import java.util.Vector;

public interface AbstractCrudInterface {
	/**
	 * Declaración de Interfaces
	 */
	public abstract String create(Vector oObject, String oModulo);
	public abstract String read(Vector oObject, String oModulo);
	public abstract String update(Vector oObject, String oModulo);
	public abstract String delete(Vector oObject, String oModulo);
}
