package com.interfac.sb.partition;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

import com.interfac.sb.batch.PersonItemProcessor;

/**
 * this class implements the {@link Partitioner} interface it is used to partition the 
 * processed data
 * @author Ali
 *
 */
@Component("rangePartitioner")
public class RangePartitioner implements Partitioner {

	private static final Logger log = LoggerFactory.getLogger(RangePartitioner.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.batch.core.partition.support.Partitioner#partition(int)
	 */
	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {

		int range = 40;
		int fromId = 1;
		int toId = range;
		
		Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>();
		
		for (int i = 1; i <= gridSize; i++) {
			ExecutionContext context = new ExecutionContext();
			
			log.info("Starting : Thread" + i + ", fromId : " + fromId + ", toId : " + toId);
			
			context.putInt("fromId", fromId);
			context.putInt("toId", toId);
			
			context.putString("name", "Thread" + i);
			
			map.put("partition" + i, context);
			
			fromId = toId + 1;
			toId += range;

		}
		
		return map;
	}

}
