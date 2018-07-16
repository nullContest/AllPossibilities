public class AllPossibilities {
    private static ICallbackAction callback = null;
    private static int nowN = 0;

    public static Boolean Start(String[] base, int n, ICallbackAction callbackAction){
        if(callbackAction != null && base != null && base.length > 0 && n > 0){
            callback = callbackAction;
            return Recu("", base, n);
        }else{
            return false;
        }
    }
    public static Boolean Start(String[] base, int min, int max, ICallbackAction callbackAction){
        if(callbackAction != null && base != null && base.length > 0 && min > 0 && max > 0) {
            callback = callbackAction;
            for (int i = min; i <= max; i++) {
                if(Recu("", base, i)){
                    return true;
                }
            }

            return false;
        }else{
            return true;
        }
    }

    static private Boolean Recu(String act, String[] base, int n){
        for(int c = 0; c < base.length; c++){
            if(n <= 1) {
                nowN++;
                if(callback.Action(act + base[c], nowN) || c == base.length){
                    return true;
                }
            }else{
                if(Recu(act + base[c], base, n-1)){
                    return true;
                }
            }
        }

        return false;
    }
}
