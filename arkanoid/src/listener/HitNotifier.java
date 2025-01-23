package listener;

/**
 * * @tzlil shkuri 314706300
 */
public interface HitNotifier {
    /**
     * @param hl -the hl we want to add.
     *           addHitListener - the function add hl as a listener to hit events.
     */
    void addHitListener(HitListener hl);

    /**
     * @param hl -the hl we want to remove.
     *           addHitListener - the function remove hl from the list of listeners to hit events.
     */
    void removeHitListener(HitListener hl);
}