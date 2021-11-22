import os
from getgauge.python import Messages
import requests


class StrapiBlog(object):
    def __init__(self, _email="", _password="", _access_token=None):
        self._email = _email
        self._password = _password
        self._access_token = _access_token

    def log_in_and_get_jwt_token(self):
        json = {'identifier': self._email, 'password': self._password}
        response = self._apiRequest(
            method='POST', endpoint='/auth/local', jsonObj=json)
        json = response.json()
        self._access_token = json['jwt']

    def get_all_posts(self):
        response = self._apiRequest(
            method='GET', endpoint='/articles')
        return response.json()

    # The generic API call below

    def _apiRequest(self, method, endpoint, jsonObj=None):
        baseurl = self._getBaseUrl()
        url = baseurl + endpoint
        headers = self._getHeaders()

        req = requests.Request(method=method, url=url,
                               params=None, json=jsonObj, headers=headers)
        prepared = req.prepare()
        self._log_request(prepared)

        s = requests.Session()
        response = s.send(prepared, verify=False)
        self._log_response(response)

        return response

    def _getBaseUrl(self):
        return os.getenv('BASE_URL')

    def _getHeaders(self):
        headers = {
            'Accept': 'application/json',
            'Content-type': 'application/json'
        }
        if self._access_token is not None:
            headers['Authorization'] = "Bearer " + self._access_token
        return headers

    def _log_request(self, req):
        Messages.write_message('\n<b>{} {}</b>'.format(req.method, req.url))
        Messages.write_message('\n<i>Request Headers:</i>')
        Messages.write_message('\n'.join('{}: {}'.format(k, v)
                               for k, v in req.headers.items()))
        Messages.write_message('\n<i>Request Body:</i>')
        Messages.write_message('{}'.format(req.body))

    def _log_response(self, res):
        Messages.write_message('\n---Response---')
        Messages.write_message(
            '<i>Status code:</i> <b>{}</b>'.format(res.status_code))
        Messages.write_message('\n<i>Response Headers:</i>')
        Messages.write_message('\n'.join('{}: {}'.format(k, v)
                               for k, v in res.headers.items()))
        if res.status_code != requests.codes.no_content:
            Messages.write_message('\n<i>Response Body:</i>')
            Messages.write_message('{}'.format(res.json()))
