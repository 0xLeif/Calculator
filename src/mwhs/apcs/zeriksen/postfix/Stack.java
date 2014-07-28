package mwhs.apcs.zeriksen.postfix;

public interface Stack<E> {
	/**
	 * Adds an object to the top of the stack
	 * @param object Object to add
	 */
	public void push(E object);
	/**
	 * Removes the object then
	 * @return The  remove object
	 */
	public E pop();
	/**
	 * @return Reference to the object on the top of the stack
	 */
	public E peek();
	/**
	 * @return Returns true if there is nothing else false
	 */
	public boolean isEmpty();
}
