import time

from locust import HttpUser, task, between, run_single_user


token = "eyJraWQiOiJEYWp2UnEwTG1IWlwvVlpxOVVWdThwMjFZNkFKY0ZVUzREekdmQ0JEZ3dKYz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJiMWU4YzAyZC1hYWNjLTRkZWMtYWRmNy1hMDcyYTNjM2YyOGUiLCJjdXN0b206dmVuZG9yIjoiS0pfQkFOSyIsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC5hcC1ub3J0aGVhc3QtMi5hbWF6b25hd3MuY29tXC9hcC1ub3J0aGVhc3QtMl94MVFISDJvQUMiLCJjb2duaXRvOnVzZXJuYW1lIjoibGluYXRlc3QwMSIsIm9yaWdpbl9qdGkiOiIzYjM4NDJiNC1jNDhiLTRkZDctOGUwNC0yMTNkMzgzMTkxYjMiLCJhdWQiOiIxbDdudXV0YnRsaHR1bmRwNzZ1b2d2c3ZiMiIsImV2ZW50X2lkIjoiZWUyYzMyNjAtNjNjOC00MDNlLTljYmMtZGFiN2I3ZWY5N2YyIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NjI1MTQ5NTIsIm5hbWUiOiJsaW5hdGVzdDAxIiwiZXhwIjoxNjYyNTM2NTUyLCJpYXQiOjE2NjI1MTQ5NTIsImp0aSI6IjhlNWI2NGJmLWEwZWYtNDQyOC1iYjNkLTk1ZTY3OGEzNmQ4MSJ9.TTUSruvZcn8EjQoP5xKDlsWkdvx6cgWYwYoLBr0adtcEiaA7rxpBXf0WJsE7IdWEQoEeis0qFTo1GiGwmQTDbbJ85m_0ZJTxrk5pvLCyKruuMadfs950Z8DrUBAxX_JDdRlGlnjvY1KQKBFoRLbt2IoN9WW9_umttwoJPZmM1r19HR-8qsERXov6QdQJpzAhj-mjm05PO08aBCa_TVGawNnqjLyLF2ldbg1PkwRruvTaIVNpzs5djQDJK52lZc_uEfOSb-k3wggLWaPG924U6J7REZIiZQOccUDQRc-iEvGXEQ3LH894lPFay1WEYVh0lwYM4SVCYWx5TCzQxl2-rQ"

bearerToken = "Bearer " + token

class QuickstartUser(HttpUser):
    wait_time = between(1, 5)

    # @task
    # def healthmanager(self):
    #     self.client.get(
    #         url="/magazine/healthcontent/personal",
    #         headers={"Authorization": "Bearer eyJraWQiOiJEYWp2UnEwTG1IWlwvVlpxOVVWdThwMjFZNkFKY0ZVUzREekdmQ0JEZ3dKYz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI3ZWQ3ZTE3Ny1mNGUwLTRhYmUtYTVhMy1kN2ViYjVkZWY3MjkiLCJjdXN0b206dmVuZG9yIjoiVEVTVF9WRU5ET1IiLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAuYXAtbm9ydGhlYXN0LTIuYW1hem9uYXdzLmNvbVwvYXAtbm9ydGhlYXN0LTJfeDFRSEgyb0FDIiwiY29nbml0bzp1c2VybmFtZSI6ImhoMDQiLCJvcmlnaW5fanRpIjoiY2VlMTJiMGQtYTJkYi00M2U0LWExMzYtYjA3M2RkYThhYjA3IiwiYXVkIjoiMWw3bnV1dGJ0bGh0dW5kcDc2dW9ndnN2YjIiLCJldmVudF9pZCI6ImIwNmVhMjQ1LTk1MzItNGNmNi1iMGQyLWRiZTBjNmE5YzBlNCIsInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNjU4ODE1OTM1LCJuYW1lIjoiaGgwNCIsImV4cCI6MTY1ODkwMjMzNSwiaWF0IjoxNjU4ODE1OTM1LCJqdGkiOiI4MGRlNWYyZS1lYmI1LTQxMzAtOTU2ZC1iYTM0NWU5YmRhMWEifQ.pc64NEfhW4pjs9ugtNhPX6yxplIbUJLB7WIgTyN2YXLrpCow6KTaXDiOGNIkVA8i8KwR2LULWEd6BA8e0aCltGkrZgGkNO53tr_qtguK0Sxc2VCdT6WS6DC1ovaZn5kNXATeLToKP6bM7kXJqCFS5SRJ0Rvoifot8ZNEoGWUEkre3-1i3725y2bG6Gtqbbuti2rEHdp_CNnOprXTpyHs1sIat3sUzElTo5TB4bmGJnBC5TiI_LHmXxVSBBtpayFhegqdGhgT2nSjomss_9ff1BaQ-SzOWiTLqgGhDeflI5NHtxKAeymL0WlN4M3p91b_zwBQMoOJDqiTDvUxFN7RGw"},
    #         name="/personal"
    #     )
    #
    # @task
    # def healthcontent_personal(self):
    #     self.client.get(
    #         url="/magazine/healthcontent/personal",
    #         headers={"Authorization": "Bearer eyJraWQiOiJEYWp2UnEwTG1IWlwvVlpxOVVWdThwMjFZNkFKY0ZVUzREekdmQ0JEZ3dKYz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI3ZWQ3ZTE3Ny1mNGUwLTRhYmUtYTVhMy1kN2ViYjVkZWY3MjkiLCJjdXN0b206dmVuZG9yIjoiVEVTVF9WRU5ET1IiLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAuYXAtbm9ydGhlYXN0LTIuYW1hem9uYXdzLmNvbVwvYXAtbm9ydGhlYXN0LTJfeDFRSEgyb0FDIiwiY29nbml0bzp1c2VybmFtZSI6ImhoMDQiLCJvcmlnaW5fanRpIjoiY2VlMTJiMGQtYTJkYi00M2U0LWExMzYtYjA3M2RkYThhYjA3IiwiYXVkIjoiMWw3bnV1dGJ0bGh0dW5kcDc2dW9ndnN2YjIiLCJldmVudF9pZCI6ImIwNmVhMjQ1LTk1MzItNGNmNi1iMGQyLWRiZTBjNmE5YzBlNCIsInRva2VuX3VzZSI6ImlkIiwiYXV0aF90aW1lIjoxNjU4ODE1OTM1LCJuYW1lIjoiaGgwNCIsImV4cCI6MTY1ODkwMjMzNSwiaWF0IjoxNjU4ODE1OTM1LCJqdGkiOiI4MGRlNWYyZS1lYmI1LTQxMzAtOTU2ZC1iYTM0NWU5YmRhMWEifQ.pc64NEfhW4pjs9ugtNhPX6yxplIbUJLB7WIgTyN2YXLrpCow6KTaXDiOGNIkVA8i8KwR2LULWEd6BA8e0aCltGkrZgGkNO53tr_qtguK0Sxc2VCdT6WS6DC1ovaZn5kNXATeLToKP6bM7kXJqCFS5SRJ0Rvoifot8ZNEoGWUEkre3-1i3725y2bG6Gtqbbuti2rEHdp_CNnOprXTpyHs1sIat3sUzElTo5TB4bmGJnBC5TiI_LHmXxVSBBtpayFhegqdGhgT2nSjomss_9ff1BaQ-SzOWiTLqgGhDeflI5NHtxKAeymL0WlN4M3p91b_zwBQMoOJDqiTDvUxFN7RGw"},
    #         name="/personal"
    #     )

    @task
    def healthcontent_personal(self):
        self.client.get(
            url="/magazine/healthcontent/personal",
            headers={"Authorization": bearerToken},
            name="/personal"
        )

    @task
    def healthcontent(self):
        for item_id in range(10):
            self.client.get(
                url="/magazine/healthcontent",
                headers={"Authorization": bearerToken},
                name="/healthcontent"
            )
            # self.client.get(f"/item?id={item_id}", name="/item")
            time.sleep(1)

    def on_start(self):
        resp = self.client.post("https://new-api-nlb.health.lina.co.kr/auth",
                                json={"age": 30, "gender": "MALE", "user_key": "linatest01", "vendor_code": "jb-c9ze8TBEFhmTbS9DHBIhsjJgzdgRwpl6CFwxXewMwF1SpZJy6B"})
        setattr(self, 'token', resp.json()['accessToken'])
        print(token)


if __name__ == "__main__":
    run_single_user(QuickstartUser)
