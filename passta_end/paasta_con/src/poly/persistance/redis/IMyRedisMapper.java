package poly.persistance.redis;

public interface IMyRedisMapper {
	
	public void doSaveData() throws Exception;
	
	public void doSaveDataforList() throws Exception;
	
	public void doSaveDataforListJSON() throws Exception;
	
	public void doSaveDataforHashTable() throws Exception;
	
	public void doSavaDataforSet() throws Exception;
	
	public void doSavaDataforZSet() throws Exception;
	
}
