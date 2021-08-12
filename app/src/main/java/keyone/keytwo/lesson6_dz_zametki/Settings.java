package keyone.keytwo.lesson6_dz_zametki;

public class Settings {

    // создаем ключи
    public static final String SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_NAME";//ключ всех настроек
    public static final String IS_BACK_STACK_USED = "IS_BACK_STACK_USED";
    public static final String IS_ADD_FRAGMENT_USED = "IS_ADD_FRAGMENT_USED"; // накладывать фрагменты
    public static final String IS_BACK_IS_REMOVE_FRAGMENT = "IS_BACK_IS_REMOVE_FRAGMENT"; // назад, удаление
    public static final String IS_DELETE_FRAGMENT_BEFORE_ADD = "IS_DELETE_FRAGMENT_BEFORE_ADD"; // удаляем предыдущий фрагмент, перед тем как загрузить новый

    //значение
    public static boolean isBackStackUsed;
    public static boolean isAddFragmentUsed;
    public static boolean isBackIsRemoveFragment;
    public static boolean isDeleteFragmentBeforeAdd;
}
