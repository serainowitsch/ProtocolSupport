package protocolsupport.utils;

public class BitUtils {

	public static boolean isIBitSet(int bitmask, int bitpos) {
		return getIBit(bitmask, bitpos) != 0;
	}

	public static int getIBit(int bitmask, int bitpos) {
		return (bitmask >>> bitpos) & 1;
	}

	public static int setIBit(int bitmask, int bitpos, int value) {
		bitmask &= ~(1L << bitpos);
		bitmask |= (value << bitpos);
		return bitmask;
	}

	public static boolean isLBitSet(long bitmask, int bitpos) {
		return getLBit(bitmask, bitpos) != 0;
	}

	public static long getLBit(long bitmask, int bitpos) {
		return (bitmask >>> bitpos) & 1;
	}

	public static long setLBit(long bitmask, int bitpos, long value) {
		bitmask &= ~(1L << bitpos);
		bitmask |= (value << bitpos);
		return bitmask;
	}

	public static int createIBitMaskFromBit(int bitpos, int value) {
		return value << bitpos;
	}

	public static long createLBitMaskFromBit(int bitpos, long value) {
		return value << bitpos;
	}

	public static int createIBitMaskFromBits(int[] bitpos, int[] values) {
		int bitmask = 0;
		int length = Math.min(bitpos.length, values.length);
		for (int i = 0; i < length; i++) {
			bitmask |= (values[i] << bitpos[i]);
		}
		return bitmask;
	}

	public static long createLBitMaskFromBits(int[] bitpos, long[] values) {
		long bitmask = 0;
		int length = Math.min(bitpos.length, values.length);
		for (int i = 0; i < length; i++) {
			bitmask |= (values[i] << bitpos[i]);
		}
		return bitmask;
	}

}
