package com.unibot.translator.block;

import com.unibot.translator.Translator;
import com.unibot.translator.block.exception.BlockException;
import com.unibot.translator.block.exception.SocketNullException;
import com.unibot.translator.block.exception.SubroutineNotDeclaredException;

public class DeclareVariableDigitalBlock extends TranslatorBlock {
	public DeclareVariableDigitalBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix,
			String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {

		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		String ret = "boolean ";
		if (!(tb instanceof VariableBlock)) {
			ret += " = ";
			// throw new BlockException(blockId, "digital var must be digital var");
		} else
			ret += tb.toCode();

		tb = this.getRequiredTranslatorBlockAtSocket(1);
		if (tb != null)
			ret += "="+tb.toCode() + " ;\n";
		else
			ret += ";\n";
		return ret;
	}

}
