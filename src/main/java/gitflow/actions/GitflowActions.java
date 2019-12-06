package gitflow.actions;

import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.*;
import org.jetbrains.concurrency.Promise;

/**
 * All actions associated with Gitflow
 *
 * @author Opher Vishnia / opherv.com / opherv@gmail.com
 */
public class GitflowActions {

    public static void runMergeTool(){
        git4idea.actions.GitResolveConflictsAction resolveAction= new git4idea.actions.GitResolveConflictsAction();
        Promise<DataContext> dataContextPromise = DataManager.getInstance().getDataContextFromFocusAsync();
        dataContextPromise.onProcessed(dataContext -> {
            AnActionEvent e = new AnActionEvent(null, dataContext, ActionPlaces.UNKNOWN, new Presentation(""), ActionManager.getInstance(), 0);
            resolveAction.actionPerformed(e);
        });
    }
}
