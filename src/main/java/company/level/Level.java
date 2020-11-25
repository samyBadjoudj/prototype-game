package company.level;

import company.actor.Actor;
import company.actor.Bullet;
import company.actor.set.EnemyImageBlock;
import company.actor.set.ImageBlock;
import company.actor.set.ImageSolidBlock;
import company.actor.set.ImageWeakBlock;
import company.animation.AlphabetSpriteAnimator;


import java.util.*;

public class Level {

    private final LevelName name;
    private final Set<Bullet> bullets = new HashSet<>();
    private final Set<ImageWeakBlock> imageWeakBlocks;
    private final Map<String,AlphabetSpriteAnimator> dialog;
    private final Map<String,AlphabetSpriteAnimator> activeDialog = new HashMap<>();
    private final Set<EnemyImageBlock> dynamicHorizontals;
    private final Set<Actor> all = new HashSet<>();
    private final Set<ImageSolidBlock> imageBlocks;
    private final ImageBlock leftBoundary;
    private final ImageBlock rightBoundary;


    public Level(LevelName name, Set<ImageWeakBlock> imageWeakBlocks, Map<String, AlphabetSpriteAnimator> dialog, Set<ImageSolidBlock> imageBlocks, Set<EnemyImageBlock> dynamicHorizontal, ImageBlock leftBoundary, ImageBlock rightBoundary) {
        this.name = name;
        this.imageWeakBlocks = imageWeakBlocks;
        this.dialog = dialog;
        this.imageBlocks = imageBlocks;
        this.dynamicHorizontals = dynamicHorizontal;
        this.all.addAll(imageBlocks);
        this.all.addAll(imageWeakBlocks);
        this.all.addAll(dynamicHorizontal);
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
    }

    public LevelName getName() {
        return name;
    }

    public Set<ImageWeakBlock> getImageWeakBlocks() {
        return imageWeakBlocks;
    }

    public Set<ImageSolidBlock> getImageBlocks() {
        return imageBlocks;
    }

    public Set<? extends Actor> getAll() {
        return all;
    }

    public void addBullet(Bullet bullet) {


            this.bullets.add(bullet);

        synchronized (all){
            this.all.add(bullet);
        }
    }

    public Set<EnemyImageBlock> getDynamicHorizontals() {
        return dynamicHorizontals;
    }

    public Set<Bullet> getBullets() {
        return this.bullets;
    }

    public ImageBlock getLeftBoundary() {
        return leftBoundary;
    }

    public ImageBlock getRightBoundary() {
        return rightBoundary;
    }

    public Map<String, AlphabetSpriteAnimator> getDialog() {
        return dialog;
    }

    public void activateDialog(String name) {
         activeDialog.put(name,new AlphabetSpriteAnimator(dialog.get(name).id,dialog.get(name).toDraw)) ;
    }

    public Map<String, AlphabetSpriteAnimator> getActiveDialog() {
        return activeDialog;
    }
}
