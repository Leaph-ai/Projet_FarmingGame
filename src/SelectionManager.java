public class SelectionManager {
    private static String currentSelection = null;

    public static void setCurrentSelection(String selection) {
        currentSelection = selection;
    }

    public static String getCurrentSelection() {
        return currentSelection;
    }
}
