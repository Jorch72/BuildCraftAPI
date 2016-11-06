package buildcraft.api.transport.neptune;

import net.minecraft.util.EnumFacing.AxisDirection;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public enum EnumWirePart {
    EAST_UP_SOUTH(true, true, true),
    EAST_UP_NORTH(true, true, false),
    EAST_DOWN_SOUTH(true, false, true),
    EAST_DOWN_NORTH(true, false, false),
    WEST_UP_SOUTH(false, true, true),
    WEST_UP_NORTH(false, true, false),
    WEST_DOWN_SOUTH(false, false, true),
    WEST_DOWN_NORTH(false, false, false);

    public static final EnumWirePart[] VALUES = values();

    public final AxisDirection x, y, z;

    /** The bounding box for rendering a wire or selecting an already-placed wire. */
    public final AxisAlignedBB boundingBox;

    /** The bounding box that is used when adding pipe wire to a pipe */
    public final AxisAlignedBB boundingBoxPossible;

    private EnumWirePart(boolean x, boolean y, boolean z) {
        this.x = x ? AxisDirection.POSITIVE : AxisDirection.NEGATIVE;
        this.y = y ? AxisDirection.POSITIVE : AxisDirection.NEGATIVE;
        this.z = z ? AxisDirection.POSITIVE : AxisDirection.NEGATIVE;
        double x1 = this.x.getOffset() * (5 / 16.0) + 0.5;
        double y1 = this.y.getOffset() * (5 / 16.0) + 0.5;
        double z1 = this.z.getOffset() * (5 / 16.0) + 0.5;
        double x2 = this.x.getOffset() * (4 / 16.0) + 0.5;
        double y2 = this.y.getOffset() * (4 / 16.0) + 0.5;
        double z2 = this.z.getOffset() * (4 / 16.0) + 0.5;
        this.boundingBox = new AxisAlignedBB(x1, y1, z1, x2, y2, z2);

        Vec3d center = new Vec3d(0.5, 0.5, 0.5);
        Vec3d edge = new Vec3d(x ? 0.75 : 0.25, y ? 0.75 : 0.25, z ? 0.75 : 0.25);
        this.boundingBoxPossible = new AxisAlignedBB(center, edge);
    }
}
