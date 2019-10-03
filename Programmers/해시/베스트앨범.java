import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Song implements Comparable {
	int idx;
	int plays;
	
	public Song(int idx, int plays) {
		this.idx = idx;
		this.plays = plays;
	}
	
	@Override
	public int compareTo(Object o) {
		Song other = (Song) o;
		if(this.plays > other.plays) {
			return 1;
		} else if(this.plays == other.plays) {
			return 0;
		} else {
			return -1;
		}
	}
	
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	Map<String, List<Song>> map = new HashMap<String, List<Song>>();
    	
    	//모든 Song들을 장르별로 map에 넣음
    	for(int i = 0; i < genres.length; i++) {
    		if(!map.containsKey(genres[i])) {
    			List<Song> list = new LinkedList<Song>();
    			list.add(new Song(i, plays[i]));
    			map.put(genres[i], list);
    		} else {
    			map.get(genres[i]).add(new Song(i, plays[i]));
    		}
    	}
    	
    	//재생횟수->genre를 이어주는 map 생성
    	Iterator<String> iter = map.keySet().iterator();
    	Map<Integer, String> playsMap = new HashMap<Integer, String>();
    	while(iter.hasNext()) {
    		String genre = iter.next();
    		List<Song> list = map.get(genre);
    		Collections.sort(list, Collections.reverseOrder());
    		Iterator<Song> iterList = list.iterator();
    		int playSum = 0;
    		while(iterList.hasNext()) {
    			Song song = iterList.next();
    			playSum += song.plays;
    		}
    		playsMap.put(playSum, genre);
    	}
    	
    	//정답 입력
    	List<Integer> answerList = new LinkedList<Integer>();
    	List<Integer> keyList = new LinkedList<Integer>(playsMap.keySet()); 
    	Collections.sort(keyList, Collections.reverseOrder());
    	Iterator<Integer> iterPlays = keyList.iterator();
    	while(iterPlays.hasNext()) {
    		List<Song> list = map.get(playsMap.get(iterPlays.next()));
    		int cnt = 0;
    		if(list.size() <= 1) {
    			cnt = 1;
    		} else {
    			cnt = 2;
    		}
    		for(int i = 0; i < cnt; i++) {
    			answerList.add(list.get(i).idx);
    		}
    	}
    	
    	Iterator<Integer> iterAnswer = answerList.iterator();
    	int[] answer = new int[answerList.size()];
    	int idx = 0;
    	while(iterAnswer.hasNext()) {
    		answer[idx++] = iterAnswer.next();
    	}
        return answer;
    }

}
