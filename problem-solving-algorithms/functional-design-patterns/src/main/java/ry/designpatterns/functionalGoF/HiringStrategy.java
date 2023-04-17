package ry.designpatterns.functionalGoF;


/**
 * The hiring strategy API (the <b>Strategy</b>).
 *
 */
public interface HiringStrategy {

	/**
	 * Decides whether a {@link Candidate} should be hired or not.
	 *
	 * @param candidate the candidate
	 * @return true if the candidate is hired, otherwise false.
	 */
	boolean hire(Candidate candidate);

}
