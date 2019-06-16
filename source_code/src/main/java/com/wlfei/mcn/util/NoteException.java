package com.wlfei.mcn.util;

public class NoteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5769693841216191813L;

	public NoteException(String msg,Throwable t){
		super(msg,t);
	}
}
