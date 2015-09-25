package framework.account;

public interface ModelVisitor<T> {
	public void accept(T x);
}
