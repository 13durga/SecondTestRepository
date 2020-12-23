package me.ANONIMUS.deobf.transformer.impl.optimization;

import me.ANONIMUS.deobf.transformer.Transformer;
import org.objectweb.asm.tree.ClassNode;

import java.util.Arrays;
import java.util.Map;

public class NopRemoverTransformer extends Transformer {
    @Override
    public void visit(Map<String, ClassNode> classMap) {
        classMap.values().forEach(classNode -> classNode.methods.forEach(methodNode -> Arrays.stream(methodNode.instructions.toArray()).filter(insnNode -> insnNode.getOpcode() == NOP).forEach(insnNode -> methodNode.instructions.remove(insnNode))));
    }
}