package yogesh.firzen.filelister;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import java.io.File;

class FilesListerView extends RecyclerView {

    private FileListerAdapter adapter;
    private FileListerAdapter.OnFileItemClickedListener onFileItemClickedListener;

    FilesListerView(Context context, FileListerAdapter.OnFileItemClickedListener onFileItemClickedListener) {
        super(context);
        this.onFileItemClickedListener = onFileItemClickedListener;
        init();
    }

    FilesListerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    FilesListerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new FileListerAdapter(this, onFileItemClickedListener);
    }

    void start() {
        setAdapter(adapter);
        adapter.start();
    }

    void setDefaultDir(File file) {
        adapter.setDefaultDir(file);
    }

    void setDefaultDir(String path) {
        setDefaultDir(new File(path));
    }

    File getSelected() {
        return adapter.getSelected();
    }

    void goToDefaultDir() {
        adapter.goToDefault();
    }

    void setFileFilter(FileListerDialog.FILE_FILTER fileFilter) {
        adapter.setFileFilter(fileFilter);
    }

    FileListerDialog.FILE_FILTER getFileFilter() {
        return adapter.getFileFilter();
    }
}
