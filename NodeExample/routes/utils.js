var DEFAULT_SIZE = 8;
function hash(h) {
	// This function ensures that hashCodes that differ only by
	// constant multiples at each bit position have a bounded
	// number of collisions (approximately 8 at default load factor).
	h ^= (h >>> 20) ^ (h >>> 12);
	return h ^ (h >>> 7) ^ (h >>> 4);
}

function indexFor(h) {
	return h & (DEFAULT_SIZE - 1);
}
function getCollectionName(lid){
	var shard=0;
	if(lid!=null&&lid!=''){
		shard=indexFor(hash(lid));
	}
	
	return "notification_"+shard;
}
exports.getCollectionName = getCollectionName;