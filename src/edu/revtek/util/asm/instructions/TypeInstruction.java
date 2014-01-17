package edu.revtek.util.asm.instructions;

import edu.revtek.util.asm.Instruction;
import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import jdk.internal.org.objectweb.asm.tree.TypeInsnNode;

/**
 * @author Caleb Whiting
 */
public class TypeInstruction implements Instruction {

    int opcode;
    String type;

    public TypeInstruction(int opcode, String type) {
        this.opcode = opcode;
        this.type = type;
    }

    @Override
    public boolean accept(AbstractInsnNode node) {
        return node.getType() == AbstractInsnNode.TYPE_INSN &&
                (opcode == -1 || opcode == node.getOpcode()) && (type.equals(((TypeInsnNode) node).desc));
    }

}
