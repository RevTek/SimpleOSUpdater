package edu.revtek.updater.container;

import edu.revtek.updater.AbstractContainer;
import edu.revtek.updater.Updater;
import jdk.internal.org.objectweb.asm.tree.ClassNode;

import java.util.Collection;
import java.util.List;

/**
 * @author Caleb Whiting
 */
public class MouseContainer extends AbstractContainer {

    @Override
    public void initKeys(List<String> keys) {

    }

    @Override
    public void initDependencies(Collection<Class> dependencies) {

    }

    @Override
    public boolean accept(ClassNode cn) {
        return cn.interfaces.contains("java/awt/event/MouseListener");
    }

    @Override
    public void visit(ClassNode cn) {
        Updater.get().getContainer(ClientContainer.class).lazyHook("mouse", "L" + cn.name + ";");
    }

}
