package geospace.control;

import geospace.entity.Bullet;
import geospace.entity.EntityModel;
import geospace.entity.Ship;
import geospace.entity.EntityManager;
import geospace.entity.Field;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CurrentGameState {

    private List<ShipInformation> ships;
    private List<BulletInformation> bullets;
    private FieldInformation field;
    private long timestamp;
    private int timeLeft;

    public CurrentGameState() {
        this.ships = new LinkedList<ShipInformation>();
        this.bullets = new LinkedList<BulletInformation>();
    }

    public void updateState(int timeLeft) {
        List<ShipInformation> iterShips = new LinkedList<ShipInformation>();
        List<BulletInformation> iterBullets = new LinkedList<BulletInformation>();

        for (EntityModel entity : EntityManager.getInstance().getEntities()) {
            if (entity instanceof Ship) {
                iterShips.add(new ShipInformation((Ship) entity));
            } else if (entity instanceof Bullet) {
                iterBullets.add(new BulletInformation((Bullet) entity));
            } else if (entity instanceof Field) {
                this.field = new FieldInformation((Field) entity);
            }
        }

        this.ships = iterShips;
        this.bullets = iterBullets;
        
        this.timestamp = new Date().getTime();
    }

    public List<ShipInformation> getShips() {
        return ships;
    }

    public void setShips(List<ShipInformation> ships) {
        // Method disabled
    }

    public List<BulletInformation> getBullets() {
        return bullets;
    }

    public void setBullets(List<BulletInformation> bullets) {
        // Method disabled
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        // Method disabled
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        // Method disabled
    }

    public FieldInformation getField() {
        return field;
    }

    public void setField(FieldInformation field) {
        // Method disabled
    }

    public ShipInformation getShipInformation(String id) {
        for (ShipInformation shipInformation : this.ships) {
            if (shipInformation.getId().equals(id)) {
                return shipInformation;
            }
        }

        return null;
    }
}