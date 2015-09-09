package com.chobitech.android.lib.components;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/*
* a class is singleton and holds the instances of TypeFace
*/
final class TtfFontHolder {

	// HashMap associates a font name(.ttf file) with a TypeFace instance
	private final HashMap<String, Typeface> mFontMap = new HashMap<>();

	private TtfFontHolder(){}

	// holder class
	private static class TtfFontHolderHolder {
		public static final TtfFontHolder INSTANCE = new TtfFontHolder();
	}

	public static TtfFontHolder getInstance() {
		return TtfFontHolderHolder.INSTANCE;
	}

	public Typeface getTypeFace(Context context, String ttfName) {
		if(mFontMap.containsKey(ttfName)) {
			return mFontMap.get(ttfName);
		} else {
			Typeface tf = Typeface.createFromAsset(context.getAssets(), ttfName);
			mFontMap.put(ttfName, tf);
			return tf;
		}
	}
}
