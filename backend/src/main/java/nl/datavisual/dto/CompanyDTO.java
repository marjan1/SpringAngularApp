package nl.datavisual.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class CompanyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idCompanies;

    private String address;

    private String companyName;

    private Date expirationDate;

    private byte[] logo;

    private int numberOfUsers;

    private String phone;

    private int statusCode;

    private List<OrganisationUnitDTO> organisationUnitDTOS;

    private List<User> users;

    public CompanyDTO() {
    }

    public int getIdCompanies() {
        return this.idCompanies;
    }

    public void setIdCompanies(int idCompanies) {
        this.idCompanies = idCompanies;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public byte[] getLogo() {
        return logo;
    }



    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public int getNumberOfUsers() {
        return this.numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<OrganisationUnitDTO> getOrganisationUnitDTOS() {
        return this.organisationUnitDTOS;
    }

    public void setOrganisationUnitDTOS(List<OrganisationUnitDTO> organisationUnitDTOS) {
        this.organisationUnitDTOS = organisationUnitDTOS;
    }

    public OrganisationUnitDTO addOrganisationUnit(OrganisationUnitDTO organisationUnitDTO) {
        getOrganisationUnitDTOS().add(organisationUnitDTO);
        organisationUnitDTO.setCompanyDTO(this);

        return organisationUnitDTO;
    }

    public OrganisationUnitDTO removeOrganisationUnit(OrganisationUnitDTO organisationUnitDTO) {
        getOrganisationUnitDTOS().remove(organisationUnitDTO);
        organisationUnitDTO.setCompanyDTO(null);

        return organisationUnitDTO;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User addUser(User user) {
        getUsers().add(user);
        user.setCompanyDTO(this);

        return user;
    }

    public User removeUser(User user) {
        getUsers().remove(user);
        user.setCompanyDTO(null);

        return user;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CompanyDTO{");
        sb.append("idCompanies=").append(idCompanies);
        sb.append(", address='").append(address).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", logo=");
        if (logo == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < logo.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(logo[i]);
            sb.append(']');
        }
        sb.append(", numberOfUsers=").append(numberOfUsers);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", statusCode=").append(statusCode);
        sb.append(", organisationUnitDTOS=").append(organisationUnitDTOS);
        sb.append(", users=").append(users);
        sb.append('}');
        return sb.toString();
    }
}