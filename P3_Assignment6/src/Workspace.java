import java.util.ArrayList;
import java.util.List;

public class Workspace {
	
	private String workspaceName, workspaceDescription;
	private User owner;
	private ArrayList<User> collaborators = new ArrayList<User>();
	
	/**
	 *constructor for the workspace object
	 *@param workspaceName the name of the workspace
	 *@param workspaceDescription a description of the workspace
	 *@param owner the owner of the workspace
	 */
	public Workspace(String workspaceName, String workspaceDescription, User owner)
	{
		this.workspaceName = workspaceName;
		this.workspaceDescription = workspaceDescription;
		this.owner = owner;
	}
	
	/**
	 *method which adds a user to the collaborators arraylist
	 *@param user which is to be added to the array
	 */
	public void addCollaborator(User user)
	{
		collaborators.add(user);
	}

	
	/**
	 *toString method describing the workspace object
	 *@return string which is a description of the workspace object
	 */
	@Override
	public String toString() {
		return "Workspace [workspaceName=" + workspaceName + ", collaborators=" + collaborators + "]\n";
	}

}
