import { WeatheruiPage } from './app.po';

describe('weatherui App', function() {
  let page: WeatheruiPage;

  beforeEach(() => {
    page = new WeatheruiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
