android Design学习日志
1:
    'ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {
             @Override
             public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                 recycleItemAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                 Collections.swap(recycleItemAdapter.getData(), viewHolder.getAdapterPosition(), target.getAdapterPosition());
                 return true;
             }

             @Override
             public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                 recycleItemAdapter.onItemDismiss(viewHolder.getAdapterPosition());
             }
         };
         ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
         itemTouchHelper.attachToRecyclerView(mRcyclerView);'
***
![image](https://github.com/BraveAction/MaterialDesign_learning/raw/master/app/screenshot1.png)
