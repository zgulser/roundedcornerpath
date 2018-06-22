/**
 * Created by ZG on 21/06/2018.
 */
public class HorizontalBarView extends FrameLayout {

    private Paint paint;
    private Path path;
    private int randomColorPicker;
    private Rect boundingRect;
    private float width;
    private float start = Float.MIN_VALUE;
    private float end = Float.MIN_VALUE;
    // ...

    public HorizontalBarView(Context context, float minPct) {
        // ...
    }

    public HorizontalBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void initView() {
        inflate(getContext(), R.layout.wl_allocation_item_layout, this);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.width = getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float start_ = getStart();
        float end_ = getEnd();
        end_ = pct > 0.0f ? start_ + end_ : start_ - (end_);
        paint.setColor(randomColorPicker);
        getDrawingRect(boundingRect);
        path.reset();
        path.moveTo(start_, boundingRect.top);
        path.lineTo(end_ - 40, boundingRect.top);
        path.arcTo(new RectF(end_- 80, boundingRect.top, end_, boundingRect.top + 80), 270, 90);
        path.lineTo(end_, boundingRect.bottom - 40);
        path.arcTo(new RectF(end_ - 80, boundingRect.bottom - 80, end_, boundingRect.bottom), 0, 90 );
        path.lineTo(end_ - 40, boundingRect.bottom);
        path.lineTo(start_, boundingRect.bottom);
        path.lineTo(start_, boundingRect.top);
        path.close();
        canvas.drawPath(path, paint);
    }

    /**
     * @return cached start point for drawing the path
     */
    private float getStart(){
        // ...
    }

    /**
     * @return cached end point for drawing the path
     */
    private float getEnd(){
        // ...
    }
}
