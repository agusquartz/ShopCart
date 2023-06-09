
package AgustinShopCart;

/**
 *
 * @author agustin
 */
public enum Colors {

    // Dark Mode Colors.
    GUNMETAL("#29323C"),            // GUNMETAL
    ARSENIC("#364649"),             // ARSENIC
    LIGHTSLATEGRAY("#708F96"),      // LIGHT SLATE GRAY
    PLATINUM("#E5E4E2"),            // PLATINUM
    MAASTRICHTBLUE("#041E40"),      // MAASTRICHT BLUE
    RICHBLACKFROGA29("#051326"),    // RICH BLACK (FOGRA29)
    FRENCHSKYBLUE("#79AEF2"),       // FRENCH SKY BLUE
    MUSTARDGREEN("#736626"),        // MUSTARDGREEN
    DEEPSPACESPARKLE("#485D61"),    // DEEP SPACE SPARKLE
    QUICKSILVER("#A6A6A6");         // QUICKSILVER// QUICKSILVER

    /**
     * Main constructor of the enum
     * @param code 
     */
    Colors(String code) {
        this.code = code;
    }

    /**
     * Returns a String of the enum
     * @return 
     */
    @Override
    public String toString() {
        return code;
    }
    
    
    // --------------- Variables ---------------
    private final String code;
}
