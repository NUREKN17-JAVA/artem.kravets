package ua.nure.kravets.usermanagement171.agent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;


import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import ua.nure.kravets.usermanagement171.User;
import ua.nure.kravets.usermanagement171.db.DaoFactory;
import ua.nure.kravets.usermanagement171.db.DatabaseException;

public class RequestServer extends CyclicBehaviour {

	@Override
	public void action() {
		ACLMessage message = myAgent.receive();
		if (message != null) {
		if (message.getPerformative() == ACLMessage.REQUEST) {
			myAgent.send(createReply(message));
		}
		else {
			Collection users = parseMessage (message);
			((SearchAgent) myAgent).showUsers(users);
		}
		} else {
			block();
		}
	}

	private ACLMessage createReply(ACLMessage message) {
		ACLMessage reply = message.createReply();
		String content = message.getContent();
		StringTokenizer tokenizer = new StringTokenizer(content, ",");
		if (tokenizer.countTokens() == 2) {
			String firstName = tokenizer.nextToken();
			String lastName = tokenizer.nextToken();
			Collection users = null;
			try {
				users = DaoFactory.getInstance().getUserDao().find(firstName, lastName);
			} catch (DatabaseException e) {
				e.printStackTrace();
				users = new ArrayList(0);
			}
			StringBuffer buffer = new StringBuffer();
			for (Iterator it = users.iterator(); it.hasNext();) {
				User user = (User) it.next();
				buffer.append(user.getId()).append(",");
				buffer.append(user.getFirstName()).append(",");
				buffer.append(user.getLastName()).append(",");
			}
			reply.setContent(buffer.toString());
		}
		return reply;
	}

	private Collection parseMessage(ACLMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

}
