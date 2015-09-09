import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TtfTextView extends TextView {

	private Context mContext;

	public TtfTextView(Context context) {
		super(context);
		mContext = context;
	}
	public TtfTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init(attrs, R.styleable.TtfTextView_ttfTextViewFontFile);
	}
	public TtfTextView(Context context, AttributeSet attrs, int defStyleArrt) {
		super(context, attrs, defStyleArrt);
		mContext = context;
		init(attrs, defStyleArrt);
	}

	private void init(AttributeSet attrs, int defStyleAttr) {
		TypedArray arr = mContext.obtainStyledAttributes(attrs, R.styleable.TtfTextView, defStyleAttr, 0);
		String ttfName = arr.getString(R.styleable.TtfTextView_ttfTextViewFontFile);
		
		/*
		* the following code is a cause of the exception
		*/
		//setTypeface(Typeface.createFromAsset(mContext.getAssets(), ttfName));
		
		/*
		* the fixed code with the class "TtfFontHolder, is a singleton and holds instances of TypeFace
		*/
		setTypeface(TtfFontHolder.getInstance().getTypeFace(mContext, ttfName));
		
		arr.recycle();
	}
}
