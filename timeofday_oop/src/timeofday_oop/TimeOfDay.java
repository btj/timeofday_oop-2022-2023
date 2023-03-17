package timeofday_oop;

// Procedure for defining a data abstraction: (= defining the API)
//
// 0. Declare the class and write a line of informal docs.
//
// 1. Define the raw abstract state space =
//    declare the inspectors = the getters
//
// 2. Define the set of valid abstract states =
//    write down the abstract state invariants
//    = @invar clauses in the class's Javadoc comment
//      and/or @post clauses in the Javadoc comments for the getters
//
// 3. Declare and document the constructors and/or factory methods and the mutators

// Procedure for implementing a data abstraction:
//
// 1. Declare the fields =
//    define the raw concrete state space
//
// 2. Define the set of valid concrete states =
//    write down the representation invariants
//
// 3. Define the mapping from concrete states to abstract states =
//    implementing the inspectors (= the getters)
//    Must satisfy the property that each valid concrete state is mapped
//    to a valid abstract state
//
// 4. Implement the constructors, factory methods, and mutators

/**
 * Each instance of this class stores a time of day with 1-minute granularity.
 * 
 * @invar | 0 <= getHours() && getHours() <= 23
 * @invar | 0 <= getMinutes() && getMinutes() <= 59
 */
public class TimeOfDay {
	
	/**
	 * @invar | 0 <= hours && hours <= 23
	 * @invar | 0 <= minutes && minutes <= 59
	 */
	private int hours;
	private int minutes;
	
	public int getHours() { return hours; }
	
	public int getMinutes() { return minutes; }
	
	/**
	 * @post | result == getHours() * 60 + getMinutes()
	 */
	public int getMinutesSinceMidnight() { return hours * 60 + minutes; }

	/**
	 * defensive programming
	 * 
	 * @throws IllegalArgumentException | hours < 0 || 23 < hours
	 * @throws IllegalArgumentException | minutes < 0 || 59 < minutes
	 * 
	 * @post | getHours() == hours
	 * @post | getMinutes() == minutes
	 */
	public TimeOfDay(int hours, int minutes) {
		if (hours < 0 || 23 < hours)
			throw new IllegalArgumentException("`hours` out of range");
		if (minutes < 0 || 59 < minutes)
			throw new IllegalArgumentException("`minutes` out of range");
		
		this.hours = hours;
		this.minutes = minutes;
	}
	
	/**
	 * contractual programming
	 * 
	 * @pre | 0 <= hours && hours <= 23
	 * @mutates | this
	 * @post | getHours() == hours
	 * @post | getMinutes() == old(getMinutes())
	 */
	public void setHours(int hours) { this.hours = hours; }
	
	/**
	 * @pre | 0 <= minutes && minutes <= 59
	 * @mutates | this
	 * @post | getHours() == old(getHours())
	 * @post | getMinutes() == minutes
	 */
	public void setMinutes(int minutes) { this.minutes = minutes; }
	
	/**
	 * @pre | 0 <= minutesSinceMidnight && minutesSinceMidnight < 24 * 60
	 * @mutates | this
	 * @post | getMinutesSinceMidnight() == minutesSinceMidnight
	 */
	public void setMinutesSinceMidnight(int minutesSinceMidnight) {
		this.hours = minutesSinceMidnight / 60;
		this.minutes = minutesSinceMidnight % 60; 
	}
	
}
