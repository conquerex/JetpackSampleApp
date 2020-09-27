package jetpack.sample.app.ui.post;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
//import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jetpack.sample.app.BR;
import jetpack.sample.app.R;
import jetpack.sample.app.util.ViewBindingHolder;

/**
 * Created by jongkook on 2020.09.12
 */
public class PostAdapter extends RecyclerView.Adapter<ViewBindingHolder> {

    // 뷰 홀더용 뷰 모델 리스트 변수
    private final List<PostItem> items = new ArrayList<>();

    // 생성자 인젝션
    @Inject
    public PostAdapter() {
        //
    }

    // 레이아웃 종류
    @Override
    public int getItemViewType(int position) {
        return R.layout.view_post;
    }

    // 뷰홀더 생성
    @NonNull
    @Override
    public ViewBindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewBindingHolder(parent.getContext(), viewType);
    }

    // 뷰 홀더와 뷰 모델을 바인딩한다.
    @Override
    public void onBindViewHolder(@NonNull ViewBindingHolder holder, int position) {
        holder.getBinding().setVariable(BR.item, items.get(position));
        holder.getBinding().executePendingBindings();
    }

    // 외부로부터 게시 글 목록을 받아서 UI를 갱신한다.
    public void setItems(List<PostItem> items) {
        this.items.clear();
        this.items.addAll(items);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
