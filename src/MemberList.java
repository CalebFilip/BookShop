import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author filip
 */
public class MemberList {
    ArrayList<Member> members;

    public MemberList() {
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void removeMember(Member member) {
        members.remove(member);
    }
}