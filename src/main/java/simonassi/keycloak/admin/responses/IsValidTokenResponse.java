package simonassi.keycloak.admin.responses;

public class IsValidTokenResponse {
    private boolean isValid;

   public IsValidTokenResponse(boolean isValid) {
       this.isValid = isValid;
   }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}
