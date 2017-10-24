package models;

import annotations.TestAnnotation;
import interfaces.ResourceInterface;

@TestAnnotation
public class Resource extends ParentResource implements ResourceInterface {

	private int id;
	private String text;

	@SuppressWarnings("unused")
	private static final String className = "ResourceClass";

	public Resource() {

	}

	@SuppressWarnings("unused")
	private Resource(String privateText) {
		this.text = privateText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		System.out.println("setText()");
		this.text = text;
	}

	@SuppressWarnings("unused")
	private static String privateMethod(String newText) {
		System.out.println("privateMethod: " + newText);
		return newText;
	}

	public String showResource(int id, String text) {
		System.out.println("showResource " + "with " + id + " " + text);
		return text;
	}

}
