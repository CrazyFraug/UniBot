package com.unibot.ui.listener;

public interface OpenblocksFrameListener {
	public void didSave();
	public void didLoad();	
	public void didGenerate(String source);
}
