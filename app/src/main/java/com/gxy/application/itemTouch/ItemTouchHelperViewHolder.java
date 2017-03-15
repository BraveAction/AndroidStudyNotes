package com.gxy.application.itemTouch;

/**
 * RecyclerView item的滑动删除与拖放接口
 * Created by Gxy on 2016/3/31
 */
public interface ItemTouchHelperViewHolder {
    /**
     * Called when the {@link ItemTouchHelper} first registers an item as being moved or swiped.
     * Implementations should update the item view to indicate it's active state.
     */
    void onItemSelected();


    /**
     * Called when the {@link ItemTouchHelper} has completed the move or swipe, and the active item
     * state should be cleared.
     */
    void onItemClear();

    /**
     * 当item 移动时的选择颜色
     */
    void onItemDragSelected();
}
