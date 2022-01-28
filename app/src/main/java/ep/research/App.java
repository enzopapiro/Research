package ep.research;

import ep.research.falsesharing.FalseSharingState;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class App {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        FalseSharingState instance = new FalseSharingState();
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
        System.out.println("The identity hash code is " + System.identityHashCode(instance));
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
    }
}
