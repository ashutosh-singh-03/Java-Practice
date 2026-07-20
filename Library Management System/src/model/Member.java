package model;

public class Member {
    private final String memberId;
    private final String name;
    private final String phone;

    public Member(String memberId, String name, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return """
                ----------------------------------------
                Member ID    : %s
                Name         : %s
                Phone        : %s
                ----------------------------------------
                """.formatted(
                memberId,
                name,
                phone
        );
    }
}
