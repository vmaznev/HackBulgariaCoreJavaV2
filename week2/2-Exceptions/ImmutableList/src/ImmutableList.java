import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.apache.commons.lang3.SerializationUtils;

public class ImmutableList<T> extends ArrayList<T> {

    private static final long serialVersionUID = 1L;

    private String userMessage = "Can't Perform That Operation! Immutable Object/s...!";
    
    public ImmutableList(Collection <? extends T> collection) {
        super.addAll(collection);
    }

    @Override
    public T get(int index) {
        return (T) SerializationUtils.clone((Serializable)super.get(index));
    }

    @Override
    public T set(int index, T element) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public boolean add(T e) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public void add(int index, T element) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public T remove(int index) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public boolean remove(Object o) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public void clear() {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new InvalidModificationException(userMessage);
    }
    
    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new InvalidModificationException(userMessage);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        throw new InvalidModificationException(userMessage);
    }
    
    @SafeVarargs
    public static <T> List<T> asList(T... arguments) {
        List<T> tempList = Arrays.asList(arguments);
        return tempList;
    }
    
}
