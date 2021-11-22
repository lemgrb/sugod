from getgauge.python import step, before_scenario, Messages, DataStoreFactory
from step_impl.api.StrapiBlog import StrapiBlog


@step("User logs in using <email> and <password> to the app")
def get_token_for_regular_user(email, password):
    appClient = StrapiBlog(_email=email, _password=password)
    DataStoreFactory.spec_data_store().put('app_client', appClient)
    appClient.log_in_and_get_jwt_token()


@step("View all the blog posts")
def view_all_the_blog_posts():
    appClient = DataStoreFactory.spec_data_store().get('app_client')
    all_posts = appClient.get_all_posts()
    assert len(all_posts) > 0, "There are > 0 articles"
